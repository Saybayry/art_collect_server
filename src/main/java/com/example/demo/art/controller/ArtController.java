package com.example.demo.art.controller;

import com.example.demo.art.model.*;
import com.example.demo.art.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/arts")
@CrossOrigin
public class ArtController {

    @Autowired
    private ArtService artService;



    @GetMapping
    public List<Art> getAllArts() {
        return artService.findAll();
    }

    @GetMapping("/{id}")
    public Art getArtById(@PathVariable Long id) {
        return artService.findById(id).orElse(null);
    }


    @PostMapping
    public Art createArt(@RequestBody Art art) {
        return artService.save(art);
    }

    @Autowired // Если ваш сервис зарегистрирован в Spring контейнере
    private GenreService genreService;
    @Autowired
    private ArtMovementService artMovementService;
    @Autowired
    private TechniqueService techniqueService;
    @Autowired
    private ArtistService artistService;

    @PostMapping("/save")
    public ResponseEntity<Art> saveArt(@ModelAttribute Art art, @RequestParam("image") MultipartFile imageFile) {
        try {
            // Здесь выполняется сохранение файла на сервере
            String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
            String filePath = "/images/" + fileName;
            File dest = new File(filePath);
            imageFile.transferTo(dest);

            // Здесь сохраняются остальные данные объекта Art
            art.setImagePath(filePath);
            Art savedArt = artService.saveArt(art);

            return new ResponseEntity<>(savedArt, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/arts/save")
    public String saveArt(
            @RequestParam("name") String name,
            @RequestParam("genreId") Long genreId,
            @RequestParam("artMovementId") Long artMovementId,
            @RequestParam("techniqueId") Long techniqueId,
            @RequestParam("artistId") Long artistId,
            @RequestParam("creationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date creationDate,
            @RequestParam("size") Long size,
            @RequestParam("tags") String tags,
            @RequestParam("image") MultipartFile image) {

        if (!image.isEmpty()) {
            try {
                // Получение байтов изображения
                byte[] imageData = image.getBytes();

                // Генерация уникального имени для изображения
                String imageName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

                // Путь к каталогу для сохранения изображения
                // String uploadDir = "src/main/resources/static/images";

                //   Путь к каталогу для сохранения изображения
                String uploadDir = "C:/images";
                // Создание каталога, если он не существует
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    if (!uploadDirFile.mkdirs()) {
                        // Обработка ошибки, если не удалось создать каталог
                        throw new IOException("Failed to create directory: " + uploadDir);
                    }
                }

                // Создание пути к новому файлу изображения
                String imagePath = uploadDir + File.separator + imageName;
                // Создание нового файла изображения
                File dest = new File(imagePath);
                // Сохранение изображения на сервере
                image.transferTo(dest);
                // Сохранение информации о картине в базе данных
                Long a = 1L;
                // поиск обектов на сервере
                Genre genre =  genreService.findById(genreId).orElse(null);
                ArtMovement artMovement = artMovementService.findById(artMovementId).orElse(null);
                Technique technique = techniqueService.findById(techniqueId).orElse(null) ;
                Artist artist = artistService.findById(artistId).orElse(null)  ;


                Art artwork = new Art(name, genre, artMovement, technique, artist, creationDate, size, tags, imageName);
                artService.saveArt(artwork);


                // Логирование или обработка успешного сохранения
                return "redirect:/success"; // Редирект на страницу успешной загрузки
            } catch (IOException e) {
                e.printStackTrace();
                // Обработка ошибок сохранения файла
            }
        }
        return "redirect:/error"; // Редирект на страницу с ошибкой загрузки
    }




    @PutMapping("/{id}")
    public Art updateArt(@PathVariable Long id, @RequestBody Art art) {
        art.setId(id);
        return artService.save(art);
    }

    @DeleteMapping("/{id}")
    public void deleteArt(@PathVariable Long id) {
        artService.deleteById(id);
    }

    @GetMapping("/by-artist/{artistId}")
    public List<Art> getArtsByArtist(@PathVariable Long artistId) {
        Artist artist = artistService.findById(artistId).orElse(null);
        if (artist == null) {
            // Обработка ситуации, когда художник с заданным ID не найден
            return null;
        }
        return artService.findByArtist(artist);
    }

    // Другие методы контроллера, если необходимо
}

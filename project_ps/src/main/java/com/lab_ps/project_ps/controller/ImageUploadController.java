package com.lab_ps.project_ps.controller;

import com.lab_ps.project_ps.dto.ImageDTO;
import com.lab_ps.project_ps.model.ImageModel;
import com.lab_ps.project_ps.model.Item;
import com.lab_ps.project_ps.repository.ImageRepository;
import com.lab_ps.project_ps.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "image")
public class ImageUploadController {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/upload")
    public RequestEntity.BodyBuilder uploadImage(@RequestBody ImageDTO dto) throws IOException {

        System.out.println("Original Image Byte Size - " + dto.getFile().getBytes().length);
        Item persistedItem = itemRepository.findById(dto.getId_item()).get();
        persistedItem.setImageUrl(dto.getFile().getOriginalFilename());
        itemRepository.save(persistedItem);
        ImageModel img = new ImageModel(dto.getFile().getOriginalFilename(), dto.getFile().getContentType(),
                compressBytes(dto.getFile().getBytes()));
        imageRepository.save(img);
        return (RequestEntity.BodyBuilder) ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {

        final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
        ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}

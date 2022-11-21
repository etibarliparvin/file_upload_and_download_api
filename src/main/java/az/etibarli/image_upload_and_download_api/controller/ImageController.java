package az.etibarli.image_upload_and_download_api.controller;

import az.etibarli.image_upload_and_download_api.service.ImageService;
import az.etibarli.image_upload_and_download_api.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Base64;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/one")
    public ResponseEntity<?> uploadOneFile(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(imageService.upload(file));
    }

    @PostMapping("/many")
    public ResponseEntity<?> uploadManyFiles(@RequestParam("files") MultipartFile[] files) throws Exception {
        return ResponseEntity.ok(imageService.uploadMany(files));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> download(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(FileUtil.encodeByteArray(imageService.download(id)));
    }
}

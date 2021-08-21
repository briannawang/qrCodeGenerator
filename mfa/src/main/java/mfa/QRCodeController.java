package mfa;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/")
public class QRCodeController {

    //Zxing library
    @GetMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> zxingUPCABarcode(@RequestParam("barcode") String barcode) throws Exception {
        return okResponse(QRCodeGenerator.generateQRCodeImage(barcode));
    }

//    @PostMapping(value = "/zxing/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
//    public ResponseEntity<BufferedImage> zxingQRCode(@RequestBody String barcode) throws Exception {
//        return okResponse(QRCodeGenerator.generateQRCodeImage(barcode));
//    }

    private ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
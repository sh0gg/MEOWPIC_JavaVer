package meowpic;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageManager {
    
    private static final String IMAGE_DIR = "images"; // Carpeta donde se guardarán las imágenes
    private List<String> images = new ArrayList<>();

    public ImageManager() {
        File directory = new File(IMAGE_DIR);
        if (!directory.exists()) {
            directory.mkdir(); // Crear la carpeta si no existe
        }
    }

    public void addImage(String imageName) {
        try {
            File imageFile = new File(IMAGE_DIR + "/" + imageName);
            if (imageFile.createNewFile()) {
                images.add(imageName);
                System.out.println("✅ Imagen guardada en: " + imageFile.getAbsolutePath());
            } else {
                System.out.println("❌ La imagen ya existe.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error al guardar la imagen: " + e.getMessage());
        }
    }

    public void showImages() {
        if (images.isEmpty()) {
            System.out.println("No hay imágenes disponibles.");
        } else {
            System.out.println("📸 Imágenes disponibles:");
            for (String image : images) {
                System.out.println("- " + image);
            }
        }
    }

    public void searchImage(String name) {
        boolean found = false;
        for (String image : images) {
            if (image.equalsIgnoreCase(name)) {
                System.out.println("✅ Imagen encontrada: " + image);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Imagen no encontrada.");
        }
    }
}

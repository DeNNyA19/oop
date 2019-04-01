package task5;

import task3.domain.Component;
import task4.Plugin;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeArchivePlugin implements Plugin {

    @Override
    public void execute(List<Component> components) {

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream("tmp.zip"))) {

            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {

                String fileName = ze.getName();
                if (!Objects.equals(fileName, "components.bin")) {
                    continue;
                }

                try (FileOutputStream fos = new FileOutputStream(new File("machinesDECOMPR.bin"))) {

                    int len;
                    byte[] buffer = new byte[1024];

                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }

                ze = zis.getNextEntry();
            }

            List<Component> machinesDec = new ArrayList<>();
            try (ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("machinesDECOMPR.bin"))) {

                while (true) {
                    machinesDec.add((Component) ois.readObject());
                }

            } catch (EOFException ex) {
                System.out.println("\nDecompresed and deserialized from zip:");
                machinesDec.forEach(System.out::println);
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDescription() {
        return "Deserialize machines from archive";
    }
}

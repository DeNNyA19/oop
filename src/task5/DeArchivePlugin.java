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
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DeArchivePlugin implements Plugin {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(List<Component> components) {
        System.out.println("\nEnter the name of unarchiving file:");
        String fileName = scanner.next();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fileName))) {

            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {

                if (!Objects.equals(ze.getName(), ze.getName().replace(".zip", ".bin"))) {
                    continue;
                }

                try (FileOutputStream fos = new FileOutputStream(new File(fileName.replace(".zip", "UNARCHIVED.bin")))) {

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
                    new ObjectInputStream(new FileInputStream(fileName.replace(".zip", "UNARCHIVED.bin")))) {

                while (true) {
                    machinesDec.add((Component) ois.readObject());
                }

            } catch (EOFException ex) {
                System.out.println("\nUnarchived and deserialized from zip:");
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

package task5;

import task3.domain.Component;
import task4.Plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchivePlugin implements Plugin {

    @Override
    public void execute(List<Component> components) {

        File bin = new File("components.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bin));
                ZipOutputStream out = new ZipOutputStream(new FileOutputStream("tmp.zip"))) {

            for (Component component : components) {
                oos.writeObject(component);
            }

            out.putNextEntry(new ZipEntry("components.bin"));

            try (FileInputStream in = new FileInputStream("components.bin")) {
                byte[] b = new byte[1024];
                int count;

                while ((count = in.read(b)) > 0) {
                    out.write(b, 0, count);
                }
            }

            bin.delete();

            System.out.println("Machines have been serialized");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDescription() {
        return "Add serialized machines to archive";
    }
}

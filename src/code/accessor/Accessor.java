package code.accessor;

import code.entity.CmsEntity;
import code.transfer.Transferable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Accessor<T> {
    private static final String RESOURCE_PATH = "src/resource/";
    private final CmsEntity cmsEntity;
    private final Transferable<T> transfer;

    public Accessor(CmsEntity cmsEntity) {
        this.cmsEntity = cmsEntity;
        this.transfer = cmsEntity.getTransfer();
    }

    // load all csv entity and transfer to object
    public List<T> loadAll(){
        List<T> entities = new ArrayList<>();
        File entityDataFile = new File(RESOURCE_PATH + cmsEntity.getFileName());
        try {
            BufferedReader entityDataReader = new BufferedReader(new FileReader(entityDataFile));
            entityDataReader.readLine();
            String entityInfo = "";
            while((entityInfo = entityDataReader.readLine()) != null) {
                String[] entityAttributes = entityInfo.split(",");
                entities.add(transfer.toObjectBy(entityAttributes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void saveAll(List<T> entities) {
        try {
            File entityDataFile = new File(RESOURCE_PATH + cmsEntity.getFileName());
            if (entityDataFile.exists()) {
                entityDataFile.delete();
            }
            entityDataFile.createNewFile();

            BufferedWriter entityDataWriter = new BufferedWriter(new FileWriter(entityDataFile, false));

            entityDataWriter.write(cmsEntity.getFileTitle());
            for (T entity : entities) {
                entityDataWriter.newLine();
                entityDataWriter.write(transfer.toStringBy(entity));
            }
            entityDataWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

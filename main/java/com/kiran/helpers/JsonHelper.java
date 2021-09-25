package com.kiran.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.kiran.JsonConverter;
import com.kiran.model.HdfsResult;
import com.kiran.model.Item;
import com.kiran.model.Root;
import com.kiran.model.ServiceRef;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class JsonHelper {
   private static final ObjectMapper mapper = getObjectMapper();
    private static final String filePath ="src/main/resources/sample.json";
    static String fileName = "hdfs_"+ System.currentTimeMillis()+".csv";
    static String csvPath ="src/main/resources/"+fileName;

    public static String readJson(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static ObjectMapper getObjectMapper()
    {
        SimpleModule mod = new SimpleModule();
        mod.addDeserializer(ServiceRef.class, new ServiceRefDeserializer());
        mod.addDeserializer(HdfsResult.class,new HdfsResultDeserializer());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(mod);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return objectMapper;
    }

    public static Root getRoot() throws IOException
    {
        String json = readJson(filePath);
        return mapper.readValue(json,Root.class);
    }

    public static String jsonConverter() throws IOException {
        String jtree = readJson(filePath);
        JsonNode jsonTree =mapper.readTree(jtree);
        JsonNode itemsNode = jsonTree.get("items");
        if(itemsNode != null) {
         //   System.out.println(itemsNode);
        }
        else {
            System.out.println("items node is not present and is null");
        }
        return itemsNode.toString();
    }

    public static void converter() throws IOException {

        String node = jsonConverter();
        Item[] items = mapper.readValue(node, Item[].class);
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(Item.class).withHeader();
        try {

           csvMapper.writerFor(items.getClass()).with(csvSchema).writeValue(new File(csvPath),items);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static CsvSchema getSchema() throws IOException {

        return CsvSchema.builder()
                .addColumn("items",CsvSchema.ColumnType.STRING)
                .addColumn("id", CsvSchema.ColumnType.STRING)
                .addColumn("name", CsvSchema.ColumnType.STRING)
                .addColumn("startTime", CsvSchema.ColumnType.STRING)
                .addColumn("active", CsvSchema.ColumnType.STRING)
                .addColumn("success", CsvSchema.ColumnType.STRING)
                .addColumn("endTime", CsvSchema.ColumnType.STRING)
                .addColumn("resultMessage", CsvSchema.ColumnType.STRING)
                .addColumn("resultDataUrl", CsvSchema.ColumnType.STRING)

                .addColumn("serviceRef",CsvSchema.ColumnType.STRING)
                .addColumn("clusterName", CsvSchema.ColumnType.STRING)
                .addColumn("serviceName", CsvSchema.ColumnType.STRING)

                .addColumn( "hdfsResult",CsvSchema.ColumnType.STRING)
                .addColumn("progress", CsvSchema.ColumnType.STRING)
                .addColumn("throughput", CsvSchema.ColumnType.STRING)
                .addColumn("remainingTime", CsvSchema.ColumnType.STRING)
                .addColumn("numBytesDryRun", CsvSchema.ColumnType.STRING)
                .addColumn("numFilesDryRun", CsvSchema.ColumnType.STRING)
                .addColumn("numFilesExpected", CsvSchema.ColumnType.STRING)
                .addColumn("numBytesExpected", CsvSchema.ColumnType.STRING)
                .addColumn("numFilesCopied", CsvSchema.ColumnType.STRING)
                .addColumn("numBytesCopied", CsvSchema.ColumnType.STRING)
                .addColumn("numFilesSkipped", CsvSchema.ColumnType.STRING)
                .addColumn("numBytesSkipped", CsvSchema.ColumnType.STRING)
                .addColumn("numFilesDeleted", CsvSchema.ColumnType.STRING)
                .addColumn("numFilesCopyFailed", CsvSchema.ColumnType.STRING)
                .addColumn("numBytesCopyFailed", CsvSchema.ColumnType.STRING)
                .addColumn("jobId", CsvSchema.ColumnType.STRING)
                .addColumn("jobDetailsUri", CsvSchema.ColumnType.STRING)
                .addColumn("dryRun", CsvSchema.ColumnType.BOOLEAN)
                .addColumn("snapshottedDirs", CsvSchema.ColumnType.STRING)
                .addColumn("failedFiles", CsvSchema.ColumnType.STRING)
                .addColumn("runAsUser", CsvSchema.ColumnType.STRING)
                .build();
    }



}

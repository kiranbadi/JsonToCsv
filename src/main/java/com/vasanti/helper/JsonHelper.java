package com.vasanti.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.vasanti.model.Item;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;


@Log4j2
public class JsonHelper {
    private static final ObjectMapper mapper = JsonObjectMapper.getInstance().getObjectMapper();
    private static final String filePath ="/Users/kiran/projects/java/JsonToCsv/JsonToCsv/src/main/resources/sample.json";
    static final String fileName = "hdfs_"+ System.currentTimeMillis()+".csv";
    static final String csvPath = "/Users/kiran/projects/java/JsonToCsv/JsonToCsv/src/main/resources/"+fileName;


    public static String readJson(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }



    public static String jsonConverter() throws IOException {
        String jtree = readJson(filePath);
        JsonNode jsonTree = mapper.readTree(jtree);
        JsonNode itemsNode = jsonTree.get("items");
        if(itemsNode != null) {
            itemsNode.forEach(node -> {
                try {
                    log.info("itemsNode : {} " , node.toString());
                } catch (Exception e) {
                    log.error("Error in converting json to csv {}  {}",e.getMessage(),e);
                }
            });
        }
        else {
            log.info("items node is not present and is null");
        }
        return Objects.requireNonNull(itemsNode).toString();
    }

    public static void converter() throws IOException {

        String node = jsonConverter();
        Item[] items = mapper.readValue(node, Item[].class);
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(Item.class).withHeader();
        try {
            csvMapper.writerFor(items.getClass()).with(csvSchema).writeValue(new File(csvPath),items);
        } catch (IOException e) {
            log.error("Error in writing to csv file {}  {}",e.getMessage(),e);
        }

    }

    @SuppressWarnings("unused")
    public static CsvSchema getSchema() {

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


package com.timmciver;

import org.apache.felix.bundlerepository.DataModelHelper;
import org.apache.felix.bundlerepository.Repository;
import org.apache.felix.bundlerepository.impl.DataModelHelperImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class App {
    public static void main(String[] args) throws Exception {
        File repoFile = new File(args[0]);
        DataModelHelper dmh = new DataModelHelperImpl();
        Repository repo = dmh.repository(repoFile.toURI().toURL());
        File outFile = File.createTempFile("obr-test-", ".xml");
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(outFile))) {
            dmh.writeRepository(repo, writer);
        }
    }
}

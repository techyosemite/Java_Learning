package stringmatching;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

public class Indexer {
public static void main(String[] args) throws Exception { 
	if (args.length != 2) {
		throw new Exception("Usage: java " + Indexer.class.getName()+ " <index dir> <data dir>");
	}
		File indexDir = new File(args[0]); 
		File dataDir = new File(args[1]);
		long start = new Date().getTime(); 
		int numIndexed = index(indexDir, dataDir); 
		long end = new Date().getTime();
		System.out.println("Indexing " + numIndexed + " files took " + (end - start) + " milliseconds");
	}

public static int index(File indexDir, File dataDir)
throws IOException {
	if (!dataDir.exists() || !dataDir.isDirectory()) { 
		throw new IOException(dataDir+ " does not exist or is not a directory");
	}
	IndexWriter writer = new IndexWriter(indexDir, new StandardAnalyzer(), true);
	writer.setUseCompoundFile(false);
	indexDirectory(writer, dataDir);
	int numIndexed = writer.docCount();
	writer.optimize();
	writer.close();
	return numIndexed;
	}
	
private static void indexDirectory(IndexWriter writer, File dir) throws IOException {
	File[] files = dir.listFiles();
	for (int i = 0; i < files.length; i++) {
		File f = files[i]; 
		if (f.isDirectory()) {
			indexDirectory(writer, f);	
		}else if (f.getName().endsWith(".txt")) {
				indexFile(writer, f);
		 }
		}
	}

private static void indexFile(IndexWriter writer, File f) throws IOException {
	if (f.isHidden() || !f.exists() || !f.canRead()) { return;
	}
	System.out.println("Indexing " + f.getCanonicalPath());
	Document doc = new Document(); 
//	doc.add(Field.Text("contents", new FileReader(f)));

	doc.add(new Field("contents", new FileReader(f),Field.TermVector.YES));
//	doc.add(Field.Keyword("filename", Êf.getCanonicalPath()));
	doc.add(new Field("filename", f.getCanonicalPath(),
			Field.Store.YES, Field.Index.TOKENIZED,
			Field.TermVector.YES));
	writer.addDocument(doc);
	}

}

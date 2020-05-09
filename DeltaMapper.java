import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeltaMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

    
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString().toLowerCase();
    
    String[] positive_words = {"good", "great", "amazing", "awesome", "wonderful", "best", "enjoyable", "fun","excellent", "pleasant", "smooth", "efficient", "love", "nice", "comfortable"};

	for (String word : positive_words){

	if(line.contains(word))
		context.write(new Text("Positive"), new IntWritable(1));

	}

    String[] negative_words = {"bad", "worst", "not", "unlikely", "worse", "beware", "horrible", "terrible", "careless", "rough", "uncomfortable", "awful", "horrid", "unacceptable", "fearful", "unpleasant"};

	for (String word : negative_words){

	if(line.contains(word))
		context.write(new Text("Negative"), new IntWritable(1));

	}

  }
}
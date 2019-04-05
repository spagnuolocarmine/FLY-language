package fly.knn.pure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;

/**
 * A pure Java implementation of KNN
 *
 */
public class KNN 
{
    public static void main( String[] args ) throws IOException
    {
    	long startTime = System.currentTimeMillis();
		Table test_set = Table.read().csv(CsvReadOptions
				.builder("20NG-test.csv")
				.maxNumberOfColumns(2000)
				.tableName("test")
				.separator(',')
				);
		Table train_set = Table.read().csv(CsvReadOptions
				.builder("20NG-train.csv")
				.maxNumberOfColumns(2000)
				.tableName("train")
				.separator(',')
				);
		int k = 3;
		int correct = 0;
		int features = 1025;

		for(int _test=0; _test < test_set.rowCount();_test++){

			int cnt = 0;
			ArrayList<Double> distances = new ArrayList<Double>();
			ArrayList<Short> nclasses = new ArrayList<Short>();

			for(int _train_set=0; _train_set< train_set.rowCount(); _train_set++){

				double sum = 0.0;
				for(int i=20; i < features; i++){
					sum += Math.pow((short)test_set.get(_test, i)- (short)train_set.get(_train_set, i),2);
				}

				Double dist_eucl = Math.sqrt(sum);
				if(cnt < k)
				{
					distances.add(dist_eucl);
					nclasses.add((short)train_set.get(_train_set, 6));
					cnt += 1;
				}
				else {

					Double max = Collections.max(distances);
					if(max < dist_eucl)
					{
						int index = distances.indexOf(max);
						distances.set(index, max);
						nclasses.set(index, (short)train_set.get(_train_set, 6));
					}
				}
			}
			int class1=0,class2=0;
			for (Short c : nclasses) {
				if(c==0)class1++; else class2++;
			}
			short predicted_class = (short) ((class1 > class2)? 0:1);
			short real_class = (short) test_set.get(_test, 6);
			correct += predicted_class!=real_class?0:1;
		}
		System.out.println("Accurancy "+((double)correct/(test_set.rowCount()))+" time:"+(System.currentTimeMillis()-startTime));
	}
    
}

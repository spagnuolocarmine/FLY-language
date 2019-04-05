import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.time.LocalDate;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.columns.Column;
import tech.tablesaw.selection.Selection;
import tech.tablesaw.table.Rows;
import tech.tablesaw.api.Row;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.CreateRoleRequest;
import com.amazonaws.services.identitymanagement.model.CreateRoleResult;
import com.amazonaws.services.identitymanagement.model.DeleteRolePolicyRequest;
import com.amazonaws.services.identitymanagement.model.DeleteRoleRequest;
import com.amazonaws.services.identitymanagement.model.PutRolePolicyRequest;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.AddPermissionRequest;
import com.amazonaws.services.lambda.model.AddPermissionResult;
import com.amazonaws.services.lambda.model.CreateFunctionRequest;
import com.amazonaws.services.lambda.model.CreateFunctionResult;
import com.amazonaws.services.lambda.model.DeleteFunctionRequest;
import com.amazonaws.services.lambda.model.FunctionCode;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.identitymanagement.model.GetRoleRequest;
import com.amazonaws.services.identitymanagement.model.GetRoleResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class knn {
	
	
	static LinkedTransferQueue<Object> result = new LinkedTransferQueue<Object>();
	
	static ExecutorService thread_pool = Executors.newFixedThreadPool(4); //modify
	
	static HashMap<String,String> __fly_function_names = new HashMap<String,String>();
	
	public static void main(String[] args) throws Exception{
						
		Table test_set = Table.read().csv(CsvReadOptions
			.builder("20NG-test.csv")
			.maxNumberOfColumns(5000)
			.tableName("test")
			.separator(',')
		);
		Long c = System.currentTimeMillis();
		final List<Future<Object>> knn_8_return = new ArrayList<Future<Object>>();
		final int __numThread = 4; //modify;
		ArrayList<Table> __list_data_knn = new ArrayList<Table>();
		for (int __i = 0; __i < __numThread; __i++) {
			__list_data_knn.add(test_set.emptyCopy());
		}
		for(int __i=0; __i<test_set.rowCount();__i++) {
			__list_data_knn.get(__i%__numThread).addRow(__i,test_set);
		}
		for(int __i=0; __i<__numThread;__i++) {
		    final int __index=__i;
		    final Table __test_set =__list_data_knn.get(__index) ; 
		    Future<Object> __f = thread_pool.submit(new Callable<Object>() {
				public Object call() throws Exception {
					// TODO Auto-generated method stub
					Object __ret = knn(__test_set);
					return __ret;
				}
				  			
			});
			knn_8_return.add(__f);
		}
		for(Future _f : knn_8_return){
			try{
				_f.get();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		estimate();
		System.out.println("elapsed " + (( System.currentTimeMillis() - c )));
		
	}
		
	
		protected static Object knn(Table test)throws Exception{
		Long t = System.currentTimeMillis();
		Table train_set = Table.read().csv(CsvReadOptions
			.builder("20NG-train.csv")
			.maxNumberOfColumns(5000)
			.tableName("train")
			.separator(',')
		);
		System.out.println("loading time " + ( System.currentTimeMillis() - t ));
		Integer k = 3;
		HashMap<Object,Object> res = new HashMap<Object,Object>();
		Integer t_res = 0;
		for(int _test=0; _test< test.rowCount();_test++){
			Integer cnt = 0;
			HashMap<Object,Object> distances = new HashMap<Object,Object>();
			HashMap<Object,Object> neighbors = new HashMap<Object,Object>();
			for(int _train_set=0; _train_set< train_set.rowCount();_train_set++){
				Double sum = 0.0;
				for(int i=0;i<1024;i++){
					{
						sum += Math.pow((int)((test.get(_test, i) instanceof Short)? new Integer((Short) test.get(_test, i)):(Integer) test.get(_test, i)) - (int)((train_set.get(_train_set, i) instanceof Short)? new Integer((Short) train_set.get(_train_set, i)):(Integer) train_set.get(_train_set, i)),2);
					}
				}
				Double dist_eucl = Math.sqrt(sum);
				if(cnt < k)
					{
						distances.put(cnt,dist_eucl);
						neighbors.put(cnt,train_set.get(_train_set, 6));
						cnt += 1;
					}
					else {
						Double max = 0.0;
						Integer i_max = 0;
						HashMap<Object, Object> d = new HashMap<Object,Object>();
						for(Object _d : distances.keySet() ){
								d.put("k",_d);
								d.put("v",distances.get(_d));
								if((double)((d.get("v") instanceof Float)? new Double((Float) d.get("v")):(Double) d.get("v")) > max)
									{
										max = (double)((d.get("v") instanceof Float)? new Double((Float) d.get("v")):(Double) d.get("v"));
										i_max = (int)((d.get("k") instanceof Short)? new Integer((Short) d.get("k")):(Integer) d.get("k"));
									}
						}
						if(max > dist_eucl)
							{
								distances.put(i_max,dist_eucl);
								neighbors.put(i_max,train_set.get(_train_set, 6));
							}
					}
			}
			Integer class1 = 0;
			Integer class2 = 0;
			HashMap<Object, Object> p = new HashMap<Object,Object>();
			for(Object _p : neighbors.keySet() ){
					p.put("k",_p);
					p.put("v",neighbors.get(_p));
					Integer neigh_class = (int)((p.get("v") instanceof Short)? new Integer((Short) p.get("v")):(Integer) p.get("v"));
					if(neigh_class == 0)
						class1 += 1;
						else class2 += 1;
			}
			Integer predicted_Class = -1;
			if(class1 > class2)
				predicted_Class = 0;
				else predicted_Class = 1;
			Integer r = -1;
			if((int)((test.get(_test, 6) instanceof Short)? new Integer((Short) test.get(_test, 6)):(Integer) test.get(_test, 6)) == predicted_Class)
				r = 1;
				else r = 0;
			res.put(t_res,r);
			t_res += 1;
			System.out.println("Instance test: " + r + " " + (int)((test.get(_test, 6) instanceof Short)? new Integer((Short) test.get(_test, 6)):(Integer) test.get(_test, 6)) + "=" + predicted_Class + " elapsed" + ( System.currentTimeMillis() - t ));
		}
		result.add(res);
		return null;
		}
						
	
		protected static Object estimate()throws Exception{
		Integer correct = 0;
		Integer nmess = 0;
		Integer totmess = 4;
		for(int i=0;i<4;i++){
			{
				HashMap<Object,Object> res = (HashMap<Object,Object>) result.take(); 
				HashMap<Object, Object> j = new HashMap<Object,Object>();
				for(Object _j : res.keySet() ){
						j.put("k",_j);
						j.put("v",res.get(_j));
						correct += Integer.parseInt( j.get("v").toString());
						nmess += 1;
						System.out.println("RCV " + nmess + "/" + totmess + " correct " + correct);
				}
			}
		}
		System.out.println("Accuracy " + (Double.parseDouble( correct.toString()) / 3000));
		return null;
		}
						
	
	private static String __generateString(Table t) {
			StringBuilder b = new StringBuilder();
			b.append("[");
			int i_r = t.rowCount();
			for(Row r : t) {
				b.append('{');
				for (int i=0;i< r.columnCount();i++) {
					b.append("\""+ r.columnNames().get(i) +"\":"+r.getObject(i)+ ((i<r.columnCount()-1)?",":""));
				}
				b.append("}"+(((i_r != 1 ))?",":""));
				i_r--;
			}
			b.append("]");
			return b.toString();
		}
}

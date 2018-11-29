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



public class pi {
	
	
	static LinkedTransferQueue<Object> ch = new LinkedTransferQueue<Object>();
	
	static ExecutorService thread_pool = Executors.newFixedThreadPool(4); //modify
	
	static HashMap<String,String> __fly_function_names = new HashMap<String,String>();
	
	public static void main(String[] args) throws Exception{
						
		final List<Future<Object>> hit_13_return = new ArrayList<Future<Object>>();
		for(int _i=0;_i<10000;_i++){
			final int __i = _i;
			Future<Object> _f = thread_pool.submit(new Callable<Object>(){
				
				public Object call() throws Exception {
					// TODO Auto-generated method stub
					
					Object __ret = hit(__i);
					return __ret;
				}
			});
			hit_13_return.add(_f);
		}
		for(Future _f : hit_13_return){
			try{
				_f.get();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		estimation();
		
	}
		
	
		protected static Object hit(Integer data)throws Exception{
		Random r = new Random();
		Double x = r.nextDouble();
		Double y = r.nextDouble();
		Integer msg = 0;
		if((x * x) + (y * y) < 1.0)
			{
				msg = 1;
			}
		ch.add(msg);
		return null;
		}
						
	
		protected static Object estimation()throws Exception{
		Integer sum = 0;
		Integer crt = 0;
		for(int i=0;i<10000;i++){
			{
				try{
					sum += Integer.parseInt(ch.take().toString());
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}
				crt += 1;
			}
		}
		System.out.println("PI approximation is " + (sum * 4.0) / crt);
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

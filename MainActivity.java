package e.saloni.task2;
import java.util.ArrayList;
import android.os.Bundle;
import java.io.*;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.nio.charset.Charset;
import java.lang.Object;
import android.content.res.Resources;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readQuizData();
    }


    private ArrayList<QuizSample> quizsamples = new ArrayList<>();

    private void readQuizData() {
        Context context = getApplicationContext();
        InputStream is = context.getResources().openRawResource(R.raw.data);
        BufferedReader read = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        try {
            //step over headers
            read.readLine();

            while ((line = read.readLine()) != null) {
                Log.d("MyActivity", "Line" + line);
             //split by commas

                String[] tokens = line.split(",");

                //read the data
                QuizSample sample = new QuizSample();
                sample.setName(tokens[0]);
                if(tokens[1].length() > 0){
                    sample.setMarks(Integer.parseInt(tokens[1]));
                }
                else{
                    sample.setMarks(0);
                }
                quizsamples.add(sample);

                Log.d("MyActivity", "Just Created:" + sample);
            }
        }catch(IOException e){
            Log.wtf("MyActivity","Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }
}
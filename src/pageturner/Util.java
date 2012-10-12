package pageturner;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;


public class Util {
	
    public static void log_debug_message(String message){
      Log.d("QuizApp", message);
	}

	public static void toast(Context context, String message){
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
//    public static void
	
}

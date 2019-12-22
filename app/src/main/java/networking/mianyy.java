package networking;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class mianyy
{

    public static void main(String[] args) {


        final userpojo myiuer = new userpojo("satish","cxxcx");
        ArrayList<String > aa= new ArrayList();

        aa.add("1");
        aa.add("2");
        aa.add("3");
        aa.add("4");
        aa.add("5");
        aa.add("6");


     Observable.fromIterable(aa).map(new Function<String, String>() {
         @Override
         public String apply(String s) throws Exception {
             return s+"welcome";
         }
     }).concatMap(new Function<String, Observable<String>>() {
         @Override
         public Observable<String> apply(String s) throws Exception {
             return getobservable(s);
         }
     }).subscribe(new Observer<String>() {
         @Override
         public void onSubscribe(Disposable d) {

         }

         @Override
         public void onNext(String s) {

             System.out.println(s);
         }

         @Override
         public void onError(Throwable e) {

         }

         @Override
         public void onComplete() {

         }
     });


        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public  static  Observable<String>  getobservable(String  ss)
    {


        final int delay = new Random().nextInt(10);
           return  Observable.just(ss).delay(delay,TimeUnit.SECONDS);




    }

    public static ObservableTransformer<String,String> applyschdulers()
    {


      return  new ObservableTransformer<String, String>() {
          @Override
          public ObservableSource<String> apply(Observable<String> upstream) {
              return upstream.subscribeOn(Schedulers.io()).observeOn(Schedulers.trampoline());
          }
      };

    }




}

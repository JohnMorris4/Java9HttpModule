package bawp.programming.courseapp;



import bawp.programming.database.Course;
import bawp.programming.database.CourseServer;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by jmorris on 3/1/18
 */
public class Main {
    public static void main(String[] args) {


        CourseServer courseServer = new CourseServer();

        List<Course> courses = courseServer.getCourseList();

        for (Course course: courses) {
            System.out.println(" Courses " + course.getCourseName());
        }

        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("http://www.google.com"))
                    .GET().build();
            try {
                HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                        HttpResponse.BodyHandler.asString());
                System.out.println(httpResponse.body());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        URL url = new URL("http://www.morrisje.com"); //Specify the URL name
//        URLConnection urlConnection = url.openConnection();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//        String inputLine;
//        while ((inputLine = reader.readLine()) != null) {
//            System.out.println(inputLine);
//
//        }
//        reader.close();
    }
}

package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightstr = request.getParameter("weight");
        String heightstr = request.getParameter("height");

        double weight = Double.parseDouble(weightstr);
        double height = Double.parseDouble(heightstr);
        //TODO: calculate bmi
        int BMI = (int) Math.round(weight / (height * height));
        //TODO: determine the built from BMI
        String result;
        if(BMI < 18.5){
            result = "underweight";
        }
        else if(BMI >= 18.5 && BMI <= 25){
            result = "normal";
        }
        else if(BMI >= 25 && BMI <= 30){
            result = "overweight";
        }
        else if(BMI >= 30 && BMI <= 35){
            result = "obese";
        }
        else{
            result = "extremely obese";
        }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("result", result);
        request.setAttribute("BMI", BMI);
        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);

    }
    
}

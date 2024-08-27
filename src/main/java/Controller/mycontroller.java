package Controller;


import image_class.image_props;
import img_inf.image_prop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class mycontroller {

    @Autowired
    private image_prop img_details;

    @GetMapping("/home")
    public String hm(){
        return "Image Gallary";
    }
    @GetMapping("/imagesList")
    public List<image_props> get_props(){
        return this.img_details.get_props();
    }

    @GetMapping("/imagesList/date")
    public List<image_props> get_props_afterdate(@RequestParam("date") String date){
        LocalDate localDate = LocalDate.parse(date);
        return this.img_details.get_props_aftedate(localDate);
    }
    @GetMapping("/imagesList/bdate")
    public List<image_props> get_props_beforedate(@RequestParam("date") String date){
        LocalDate localDate = LocalDate.parse(date);
        return this.img_details.get_props_beforedate(localDate);
    }

    @GetMapping("/imagesList/category")
    public List<image_props> get_props_catagory(@RequestParam("category") String category){
        return this.img_details.get_image_props_of_catagory(category);
    }

    @GetMapping("/imagesList/categoryAndDate")
    public List<image_props> get_props_date_and_time(@RequestParam("category") String category,@RequestParam("date") String date){
        LocalDate localDate = LocalDate.parse(date);
        return this.img_details.get_props_date_and_category(category,date);
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDateTimeParseException(DateTimeParseException ex) {
        return "Invalid date format. Please use YYYY-MM-DD.";
    }



}

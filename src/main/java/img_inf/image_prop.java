package img_inf;

import image_class.image_props;

import java.time.LocalDate;
import java.util.List;

public interface image_prop {

    List<image_props> get_props();


    List<image_props> get_props_aftedate(LocalDate date);

    List<image_props> get_image_props_of_catagory(String category);

    List<image_props> get_props_date_and_category(String category, String date);

    List<image_props> get_props_beforedate(LocalDate localDate);
}

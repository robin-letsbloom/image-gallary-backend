package connect_to_mysql;


import image_class.image_props;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface sql extends JpaRepository<image_props, Integer> {

    @Query(value = "SELECT * FROM gallery WHERE upload_date >= :date", nativeQuery = true)
    List<image_props> findImagesOnOrAfterDate(@Param("date") LocalDate date);


    @Query(value = "SELECT * FROM gallery WHERE image_category=:category",nativeQuery = true)
    List<image_props> find_images_of_categorty(@Param("category") String category);


    @Query(value = "SELECT * FROM gallery WHERE image_category=:category AND upload_date>= :date",nativeQuery = true)
    List<image_props> find_images_on_date_and_category(@Param("category") String category,@Param("date") String date);

    @Query(value = "SELECT * FROM gallery WHERE upload_date < :date",nativeQuery = true)
    List<image_props> find_image_before_that_date(@Param("date") LocalDate date);
}


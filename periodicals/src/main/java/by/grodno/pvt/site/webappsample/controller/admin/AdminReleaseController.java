package by.grodno.pvt.site.webappsample.controller.admin;

import by.grodno.pvt.site.webappsample.domain.Product;
import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.repo.ReleaseRepo;
import by.grodno.pvt.site.webappsample.service.ProductService;
import by.grodno.pvt.site.webappsample.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class AdminReleaseController {

    @Autowired
    private ReleaseRepo releaseRepo;
    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private ProductService productService;

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/admin/release")
    public String getAllRelease(Model model){

        model.addAttribute("release", releaseService.getReleases());
        model.addAttribute("product", productService.getProducts());
        return "/admin/release";

    }
    @PostMapping("/admin/release")
    public String addRelease(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Double price,
                             Map<String, Object> model,
                             Product product,
                             @RequestParam("file") MultipartFile file) throws IOException {
        Release release = new Release(name, description, price);
        release.setProduct(product);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            release.setFilename(resultFilename);
        }
        releaseService.saveRelease(release);

        return "redirect:/admin/release";
    }

    @GetMapping("/admin/release/delete")
    public String deleteRelease(@RequestParam(value="id") Integer id){

        releaseRepo.deleteById(id);
        return "redirect:/admin/release";
    }


    @GetMapping("/admin/release/edit")
    public String getRelease(@RequestParam(value="id") Integer id, Model model){
        Release release = releaseRepo.getOne(id);
        model.addAttribute("release", release);

        return "/admin/release";

    }

    @PostMapping("/admin/release/edit")
    public String editRelease(@RequestParam (value="id") Integer id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Double price) {
        Release release = releaseRepo.getOne(id);
        release.setName(name);
        release.setDescription(description);
        release.setPrice(price);
        releaseService.saveRelease(release);
        return "redirect:/admin/release";
    }




}

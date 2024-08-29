package yoyama.imc;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "imc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ImcController {
    private ImcService imcService;
    @PostMapping
    public @ResponseBody Map<String, String>calculate(@RequestBody ImcDTO data){
        return imcService.calculate(data);
    }
}

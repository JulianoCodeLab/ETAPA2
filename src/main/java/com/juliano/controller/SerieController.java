package com.juliano.controller;


import com.juliano.SerieDto;
import com.juliano.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController // determina que este é o controlador para o springboot
@RequestMapping("/series") // pra não repetir /series em todos os @GetMapping
public class SerieController {


    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDto> obterSeries(){
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDto> obterTop5Series() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDto> obterLancamentos() {
        return servico.obterLancamentos();
    }

}

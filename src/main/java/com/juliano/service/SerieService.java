package com.juliano.service;

import com.juliano.SerieDto;
import com.juliano.reppository.SerieRepository;
import com.juliano.model.Series;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SerieService {

    @Autowired
    private SerieRepository repositorio;

    public List<SerieDto> obterTodasAsSeries(){
        return converteDados(repositorio.findAll());
    }

    public List<SerieDto> obterTop5Series() {
        return converteDados(repositorio.findTop5ByOrderByAvaliacaoDesc());

    }

    private List<SerieDto> converteDados(List<Series> series) {
        return series.stream()
                .map(s -> new SerieDto(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }

    public List<SerieDto> obterLancamentos() {
        return converteDados(repositorio.findTop5ByOrderByEpisodiosDataLancamentoDesc());
    }
}

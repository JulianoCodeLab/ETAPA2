package com.juliano.reppository;

import com.juliano.model.Categoria;
import com.juliano.model.Episodio;
import com.juliano.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Series, Long> {
    Optional<Series> findByTituloContainingIgnoreCase(String nomeSerie);

    //List<Serie> findByAtoresContainingIgnoreCaseAndGenero(String nomeAtor,Categoria categoria);

    List<Series> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

    List<Series> findByGeneroAndAvaliacaoGreaterThanEqual(Categoria categoria, double avaliacao);

    List<Series> findTop5ByOrderByAvaliacaoDesc();

    List<Series> findByGenero(Categoria categoria);

    List<Series> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);


    //select * from series WHERE series.total_temporadas <= 5 AND series.avaliacao >= 7.5
    @Query("select s from Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.avaliacao >= :avaliacao")
    List<Series> seriesPorTemporadaEAValiacao(int totalTemporadas, double avaliacao);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodiosPorSerie(Series serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episodio> episodiosPorSerieEAno(Series serie, int anoLancamento);

    List<Series> findTop5ByOrderByEpisodiosDataLancamentoDesc();

    List<Series> findAll();
}

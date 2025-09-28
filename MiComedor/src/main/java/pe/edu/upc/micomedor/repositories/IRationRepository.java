package pe.edu.upc.micomedor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Ration;

@Repository
public interface IRationRepository extends JpaRepository<Ration, Integer> {
    @Query(value = "select * from ration where user_id = :idUser", nativeQuery = true)
    List<Ration> findRationByUserId(@Param("idUser") int idUser);

    @Query(value = "SELECT COUNT(*) AS total_raciones_hoy FROM ration WHERE date = CURRENT_DATE AND user_id =  :idUser", nativeQuery = true)
    Integer reporteDiarioRacionPorDia (@Param("idUser") int idUser);

    @Query(value = "WITH dias_semana AS ( SELECT generate_series( date_trunc('week', CURRENT_DATE)::date, date_trunc('week', CURRENT_DATE)::date + 6, interval '1 day' )::date AS dia)\n" +
            "SELECT \n" +
            "  CASE EXTRACT(DOW FROM d.dia)\n" +
            "    WHEN 0 THEN 'domingo'\n" +
            "    WHEN 1 THEN 'lunes'\n" +
            "    WHEN 2 THEN 'martes'\n" +
            "    WHEN 3 THEN 'miércoles'\n" +
            "    WHEN 4 THEN 'jueves'\n" +
            "    WHEN 5 THEN 'viernes'\n" +
            "    WHEN 6 THEN 'sábado'\n" +
            "  END AS nombre_dia,\n" +
            "  TO_CHAR(d.dia, 'DD/MM') AS fecha,\n" +
            "  COUNT(r.id_ration) AS total_raciones\n" +
            "FROM dias_semana d \n" +
            "LEFT JOIN ration r \n" +
            "  ON r.date = d.dia AND r.user_id = :idUser\n" +
            "GROUP BY d.dia\n" +
            "ORDER BY d.dia", nativeQuery = true)
    List<Object[]> reporteSemanalRaciones(@Param("idUser") int idUser);

    @Query(value = "SELECT COUNT(DISTINCT beneficiary_id) AS beneficiarios_hoy\n" +
            "FROM ration\n" +
            "WHERE date = CURRENT_DATE\n" +
            "  AND user_id =  :idUser", nativeQuery = true)
    List<Object[]> cantidadBeneficiarioPorDia(@Param("idUser") int idUser);

    @Query(value = "WITH dias_semana AS (\n" +
            "  SELECT generate_series(\n" +
            "    date_trunc('week', CURRENT_DATE)::date, \n" +
            "    date_trunc('week', CURRENT_DATE)::date + 6, \n" +
            "    interval '1 day'\n" +
            "  )::date AS dia\n" +
            ")\n" +
            "SELECT \n" +
            "  CASE EXTRACT(DOW FROM d.dia)\n" +
            "    WHEN 0 THEN 'domingo'\n" +
            "    WHEN 1 THEN 'lunes'\n" +
            "    WHEN 2 THEN 'martes'\n" +
            "    WHEN 3 THEN 'miércoles'\n" +
            "    WHEN 4 THEN 'jueves'\n" +
            "    WHEN 5 THEN 'viernes'\n" +
            "    WHEN 6 THEN 'sábado'\n" +
            "  END AS nombre_dia,\n" +
            "  TO_CHAR(d.dia, 'DD/MM') AS fecha,\n" +
            "  COUNT(DISTINCT r.beneficiary_id) AS beneficiarios\n" +
            "FROM dias_semana d\n" +
            "LEFT JOIN ration r \n" +
            "  ON r.date = d.dia AND r.user_id = :idUser\n" +
            "GROUP BY d.dia\n" +
            "ORDER BY d.dia;\n", nativeQuery = true)
    List<Object[]> cantidadBeneficiarioPorSemana(@Param("idUser") int idUser);
}

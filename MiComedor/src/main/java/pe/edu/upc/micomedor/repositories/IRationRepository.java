package pe.edu.upc.micomedor.repositories;

import java.time.LocalDate;
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

    @Query(value = """
        SELECT COUNT(*)
        FROM ration r
        WHERE r.user_id = :idUser
          AND r."date"::date = (now() AT TIME ZONE 'America/Lima')::date
    """, nativeQuery = true)
    Integer reporteDiarioRacionPorDia (@Param("idUser") int idUser);

    @Query(value = """
        WITH dias_semana AS (
          SELECT generate_series(
            date_trunc('week', (now() AT TIME ZONE 'America/Lima'))::date,
            date_trunc('week', (now() AT TIME ZONE 'America/Lima'))::date + 6,
            interval '1 day'
          )::date AS dia
        )
        SELECT
          CASE EXTRACT(DOW FROM d.dia)
            WHEN 0 THEN 'domingo'
            WHEN 1 THEN 'lunes'
            WHEN 2 THEN 'martes'
            WHEN 3 THEN 'miércoles'
            WHEN 4 THEN 'jueves'
            WHEN 5 THEN 'viernes'
            WHEN 6 THEN 'sábado'
          END AS nombre_dia,
          TO_CHAR(d.dia, 'DD/MM') AS fecha,
          COUNT(r.id_ration) AS total_raciones
        FROM dias_semana d
        LEFT JOIN ration r
          ON r."date"::date = d.dia
         AND r.user_id = :idUser
        GROUP BY d.dia
        ORDER BY d.dia
    """, nativeQuery = true)
    List<Object[]> reporteSemanalRaciones(@Param("idUser") int idUser);

    @Query(value = """
        SELECT COUNT(DISTINCT r.beneficiary_id)
        FROM ration r
        WHERE r.user_id = :idUser
          AND r."date"::date = (now() AT TIME ZONE 'America/Lima')::date
    """, nativeQuery = true)
    List<Object[]> cantidadBeneficiarioPorDia(@Param("idUser") int idUser);

    @Query(value = """
        WITH dias_semana AS (
          SELECT generate_series(
            date_trunc('week', (now() AT TIME ZONE 'America/Lima'))::date,
            date_trunc('week', (now() AT TIME ZONE 'America/Lima'))::date + 6,
            interval '1 day'
          )::date AS dia
        )
        SELECT
          CASE EXTRACT(DOW FROM d.dia)
            WHEN 0 THEN 'domingo'
            WHEN 1 THEN 'lunes'
            WHEN 2 THEN 'martes'
            WHEN 3 THEN 'miércoles'
            WHEN 4 THEN 'jueves'
            WHEN 5 THEN 'viernes'
            WHEN 6 THEN 'sábado'
          END AS nombre_dia,
          TO_CHAR(d.dia, 'DD/MM') AS fecha,
          COUNT(DISTINCT r.beneficiary_id) AS beneficiarios
        FROM dias_semana d
        LEFT JOIN ration r
          ON r."date"::date = d.dia
         AND r.user_id = :idUser
        GROUP BY d.dia
        ORDER BY d.dia
    """, nativeQuery = true)
    List<Object[]> cantidadBeneficiarioPorSemana(@Param("idUser") int idUser);


    // === NUEVO ===
    // Suma del precio de raciones por usuario y fecha
    @Query("SELECT COALESCE(SUM(r.price), 0) " +
            "FROM Ration r " +
            "WHERE r.users.idUser = :idUser AND r.date = :date")
    Float sumPriceByUserAndDate(@Param("idUser") int idUser, @Param("date") LocalDate date);

    // Conteo de raciones por usuario y fecha (para descripción)
    @Query("SELECT COUNT(r) " +
            "FROM Ration r " +
            "WHERE r.users.idUser = :idUser AND r.date = :date")
    Long countByUserAndDate(@Param("idUser") int idUser, @Param("date") LocalDate date);

}

package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Budget;
import java.util.List;

@Repository
public interface IBudgetRepository extends JpaRepository<Budget,Integer> {
    @Query(value = "SELECT \n" +
            "  SUM(CASE WHEN budget_category_id = 1 THEN amount_budget ELSE 0 END) AS ingresos_hoy,\n" +
            "  SUM(CASE WHEN budget_category_id = 2 THEN amount_budget ELSE 0 END) AS egresos_hoy,\n" +
            "  SUM(CASE WHEN budget_category_id = 1 THEN amount_budget ELSE 0 END) -\n" +
            "  SUM(CASE WHEN budget_category_id = 2 THEN amount_budget ELSE 0 END) AS saldo_final\n" +
            "FROM budget\n" +
            "WHERE date_budget = (now() AT TIME ZONE 'America/Lima')::date\n" +
            "  AND user_id = :idUser",
            nativeQuery = true)
    List<Object[]> PresupuestoPorDia(@Param("idUser") int idUser);

    @Query(value = "WITH dias_semana AS (\n" +
            "  SELECT generate_series(\n" +
            "    date_trunc('week', CURRENT_DATE)::date,\n" +
            "    date_trunc('week', CURRENT_DATE)::date + 6,\n" +
            "    interval '1 day'\n" +
            "  )::date AS dia\n" +
            "),\n" +
            "datos_diarios AS (\n" +
            "  SELECT\n" +
            "    d.dia,\n" +
            "    CASE EXTRACT(DOW FROM d.dia)\n" +
            "      WHEN 0 THEN 'Domingo'\n" +
            "      WHEN 1 THEN 'Lunes'\n" +
            "      WHEN 2 THEN 'Martes'\n" +
            "      WHEN 3 THEN 'Miércoles'\n" +
            "      WHEN 4 THEN 'Jueves'\n" +
            "      WHEN 5 THEN 'Viernes'\n" +
            "      WHEN 6 THEN 'Sábado'\n" +
            "    END AS nombre_dia,\n" +
            "    TO_CHAR(d.dia, 'DD/MM') AS fecha,\n" +
            "    COALESCE(SUM(CASE WHEN b.budget_category_id = 2 THEN b.amount_budget ELSE 0 END), 0) AS ingresos,\n" +
            "    COALESCE(SUM(CASE WHEN b.budget_category_id = 1 THEN b.amount_budget ELSE 0 END), 0) AS egresos,\n" +
            "    COALESCE(SUM(CASE WHEN b.budget_category_id = 2 THEN b.amount_budget ELSE 0 END), 0) -\n" +
            "    COALESCE(SUM(CASE WHEN b.budget_category_id = 1 THEN b.amount_budget ELSE 0 END), 0) AS saldo\n" +
            "  FROM dias_semana d\n" +
            "  LEFT JOIN budget b ON b.date_budget = d.dia AND b.user_id = :idUser\n" +
            "  GROUP BY d.dia\n" +
            ")\n" +
            "-- Resultados diarios + total semanal al final\n" +
            "SELECT * FROM datos_diarios\n" +
            "UNION ALL\n" +
            "SELECT \n" +
            "  NULL AS dia,\n" +
            "  'Total semanal',\n" +
            "  NULL,\n" +
            "  SUM(ingresos),\n" +
            "  SUM(egresos),\n" +
            "  SUM(saldo)\n" +
            "FROM datos_diarios\n" +
            "ORDER BY dia NULLS LAST;\n", nativeQuery = true)
    List<Object[]> PresupuestoPorSemana(@Param("idUser") int idUser);


}

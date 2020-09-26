package example.dao_style_file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import example.dao_style_file.dao.EmployeeDao;
import example.dao_style_file.dao.EmployeeDaoImpl;
import example.dao_style_file.entity.Employee;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.seasar.doma.jdbc.Config;

@ExtendWith(TestEnvironment.class)
public class DeleteTest {

  private final EmployeeDao dao;

  public DeleteTest(Config config) {
    Objects.requireNonNull(config);
    this.dao = new EmployeeDaoImpl(config);
  }

  @Test
  public void testDelete() {
    Employee employee = dao.selectById(1);
    int rows = dao.delete(employee);
    assertEquals(1, rows);
  }
}

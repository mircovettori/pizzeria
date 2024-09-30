package pizzeria.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.apache.commons.lang3.reflect.FieldUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class GenericDomain {

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "id")
  private UUID id;

  /** @param source Domain object to merge to actual domain object */
  public <T extends GenericDomain> void mergeWith(T source) {
    FieldUtils.getAllFieldsList(getClass())
        .forEach(
            field -> {
              try {
                field.setAccessible(true);
                if (field.get(this) == null) {
                  field.set(this, field.get(source));
                }
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              }
            });
  }


}

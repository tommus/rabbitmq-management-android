package co.windly.rabbitmqmanagement.network.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.reactivex.annotations.NonNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExtendedUser extends User {

  //region Constructor

  private ExtendedUser() {
    // Jackson requires presence of empty constructor.
  }

  public ExtendedUser(@NonNull String password, @NonNull List<Tag> tags) {
    setPassword(password);
    setTags(tags);
  }

  //endregion

  //region Hashing Algorithm

  @JsonProperty(value = "hashing_algorithm")
  private String hashingAlgorithm;

  public String getHashingAlgorithm() {
    return hashingAlgorithm;
  }

  public void setHashingAlgorithm(String hashingAlgorithm) {
    this.hashingAlgorithm = hashingAlgorithm;
  }

  //endregion

  //region Password Hash

  @JsonProperty(value = "password_hash")
  private String passwordHash;

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  //endregion

  //region Password

  @JsonProperty(value = "password")
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  //endregion
}

package io.catalyte.training.entitites;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "encounter")
public class Encounter {

  @Id
  @GeneratedValue
  @Required
  private Long id;

  @Required
  @NotNull
  private Long patientId;

  private String notes;

  @Required
  @NotBlank
  @Pattern(regexp = "^([A-Za-z]\\d[A-Za-z][\" \"]\\d[A-Za-z]\\d)", message = "Must be in the format of LDL DLD")
  private String visitCode;

  @Required
  @NotBlank
  private String provider;

  @Required
  @NotBlank
  @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "Must be a valid billing code in DDD.DDD.DDD-DD")
  private String billingCode;

  @Required
  @NotBlank
  @Pattern(regexp = "^[A-Za-z]\\d{2}", message = "Must be in LDD format")
  private String icd10;

  @Required
  @NotNull
  private Number totalCost;

  @Required
  @NotNull
  private Number copay;

  @Required
  @NotBlank
  private String chiefComplaint;

  private Number pulse;

  private Number systolic;

  private Number diastolic;

  @Required
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  public Encounter() {

  }

  public Encounter(Long id, Long patientId, String notes, String visitCode, String provider,
      String billingCode, String icd10, Number totalCost, Number copay,
      String chiefComplaint, Number pulse, Number systolic, Number diastolic, Date date) {
    this.id = id;
    this.patientId = patientId;
    this.notes = notes;
    this.visitCode = visitCode;
    this.provider = provider;
    this.billingCode = billingCode;
    this.icd10 = icd10;
    this.totalCost = totalCost;
    this.copay = copay;
    this.chiefComplaint = chiefComplaint;
    this.pulse = pulse;
    this.systolic = systolic;
    this.diastolic = diastolic;
    this.date = date;
  }

  public Number getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Number totalCost) {
    this.totalCost = totalCost;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getVisitCode() {
    return visitCode;
  }

  public void setVisitCode(String visitCode) {
    this.visitCode = visitCode;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getBillingCode() {
    return billingCode;
  }

  public void setBillingCode(String billingCode) {
    this.billingCode = billingCode;
  }

  public String getIcd10() {
    return icd10;
  }

  public void setIcd10(String icd10) {
    this.icd10 = icd10;
  }

  public Number getCopay() {
    return copay;
  }

  public void setCopay(Number copay) {
    this.copay = copay;
  }

  public String getChiefComplaint() {
    return chiefComplaint;
  }

  public void setChiefComplaint(String chiefComplaint) {
    this.chiefComplaint = chiefComplaint;
  }

  public Number getPulse() {
    return pulse;
  }

  public void setPulse(Number pulse) {
    this.pulse = pulse;
  }

  public Number getSystolic() {
    return systolic;
  }

  public void setSystolic(Number systolic) {
    this.systolic = systolic;
  }

  public Number getDiastolic() {
    return diastolic;
  }

  public void setDiastolic(Number diastolic) {
    this.diastolic = diastolic;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Encounter)) {
      return false;
    }
    Encounter encounter = (Encounter) o;
    return Objects.equals(getId(), encounter.getId()) &&
        Objects.equals(getPatientId(), encounter.getPatientId()) &&
        Objects.equals(getNotes(), encounter.getNotes()) &&
        Objects.equals(getVisitCode(), encounter.getVisitCode()) &&
        Objects.equals(getProvider(), encounter.getProvider()) &&
        Objects.equals(getBillingCode(), encounter.getBillingCode()) &&
        Objects.equals(getIcd10(), encounter.getIcd10()) &&
        Objects.equals(getTotalCost(), encounter.getTotalCost()) &&
        Objects.equals(getCopay(), encounter.getCopay()) &&
        Objects.equals(getChiefComplaint(), encounter.getChiefComplaint()) &&
        Objects.equals(getPulse(), encounter.getPulse()) &&
        Objects.equals(getSystolic(), encounter.getSystolic()) &&
        Objects.equals(getDiastolic(), encounter.getDiastolic()) &&
        Objects.equals(getDate(), encounter.getDate());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getPatientId(), getNotes(), getVisitCode(), getProvider(), getBillingCode(),
            getIcd10(), getTotalCost(), getCopay(), getChiefComplaint(), getPulse(), getSystolic(),
            getDiastolic(), getDate());
  }

  @JsonIgnore
  public boolean isEmpty() {
    return Objects.isNull(id) &&
        Objects.isNull(patientId) &&
        Objects.isNull(notes) &&
        Objects.isNull(visitCode) &&
        Objects.isNull(provider) &&
        Objects.isNull(billingCode) &&
        Objects.isNull(icd10) &&
        Objects.isNull(totalCost) &&
        Objects.isNull(copay) &&
        Objects.isNull(chiefComplaint) &&
        Objects.isNull(pulse) &&
        Objects.isNull(systolic) &&
        Objects.isNull(diastolic) &&
        Objects.isNull(date);
  }
}

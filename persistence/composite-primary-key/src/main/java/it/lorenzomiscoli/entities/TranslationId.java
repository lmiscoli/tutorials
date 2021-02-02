package it.lorenzomiscoli.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TranslationId implements Serializable {

	@Column(name = "translation_id")
	private Long translationId;

	@ManyToOne
	@JoinColumn(name = "language_code")
	private Language language;

	public TranslationId() {
	}

	public TranslationId(Long translationId, Language language) {
		this.translationId = translationId;
		this.language = language;
	}

	public Long getTranslationId() {
		return translationId;
	}

	public Language getLanguage() {
		return language;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EmployeeId))
			return false;
		TranslationId translationId = (TranslationId) o;
		return Objects.equals(getTranslationId(), translationId.getTranslationId())
				&& Objects.equals(getLanguage(), translationId.getLanguage());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTranslationId(), getLanguage());
	}
}

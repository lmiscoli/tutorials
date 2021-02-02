package it.lorenzomiscoli.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="translation")
public class Translation {

	@EmbeddedId
	private TranslationId translationId;

	public TranslationId getTranslationId() {
		return translationId;
	}

	public void setTranslationId(TranslationId translationId) {
		this.translationId = translationId;
	}


}

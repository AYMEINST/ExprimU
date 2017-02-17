package org.exprimu.prog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fichier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFichier;
	private String name;
	private String mime;
	private Long size;
	@Column(columnDefinition="LONGBLOB")
	private byte[] data;

	public Fichier() {
	}

	public Fichier(String name, String mime, Long size, byte[] data) {
		this.name = name;
		this.mime = mime;
		this.size = size;
		this.data = data;
	}

	public Long getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(Long idFichier) {
		this.idFichier = idFichier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fichier other = (Fichier) obj;
		if (idFichier == null) {
			if (other.idFichier != null)
				return false;
		} else if (!idFichier.equals(other.idFichier))
			return false;
		return true;
	}

}

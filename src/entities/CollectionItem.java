package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "collection")
public class CollectionItem {

	public CollectionItem() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	private String artist;
	private String title;
	private String year;
	private String materials;
	private String location;

	public CollectionItem(String id, String artist, String title, String year, String materials, String location) {
		this.id = id;
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.materials = materials;
		this.location = location;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "Artist")
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Column(name= "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void insertPiece(CollectionItem c) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MuseumCollectionJPAFarrington");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

	public void getAllPieces() {
		//List<CollectionItem> allPieces = new ArrayList<CollectionItem>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MuseumCollectionJPAFarrington");
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<CollectionItem> query = em.createQuery("SELECT c FROM CollectionItem c", CollectionItem.class);
			List<CollectionItem> results = query.getResultList();
			em.getTransaction().begin();
			
			for (CollectionItem c:results) {
			System.out.print(c.getId() + "--");
			System.out.print(c.getArtist()+ "--");
			System.out.print(c.getTitle()+ "--");
			System.out.print(c.getYear()+ "--");
			System.out.print(c.getMaterials()+ "--");
			System.out.print(c.getLocation()+ "--");
			System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emf.close();
		}
		
	}

	public void editPiece(CollectionItem c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MuseumCollectionJPAFarrington");
		EntityManager em = emf.createEntityManager();
		CollectionItem toUpdate = em.find(CollectionItem.class, c.getId());
		toUpdate.setArtist(c.getArtist());
		toUpdate.setTitle(c.getTitle());
		toUpdate.setYear(c.getYear());
		toUpdate.setMaterials(c.getMaterials());
		toUpdate.setLocation(c.getLocation());
		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public void deletePiece(CollectionItem c) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MuseumCollectionJPAFarrington");
		EntityManager em = emf.createEntityManager();
		CollectionItem toRemove = em.find(CollectionItem.class, c.getId());
		em.remove(toRemove);
		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}

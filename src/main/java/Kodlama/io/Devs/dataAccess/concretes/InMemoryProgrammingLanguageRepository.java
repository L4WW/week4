package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
	List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage pl : programmingLanguages) {
			if (pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("isim tekrar edemez");

			}

		}
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage pl : programmingLanguages) {
			if (pl.getId() == (programmingLanguage.getId())) {
				programmingLanguages.remove(pl);

			} 

		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage pl : programmingLanguages) {
			if (programmingLanguage.getId() == pl.getId()) {
				pl.setId(programmingLanguage.getId());
				pl.setName(programmingLanguage.getName());
			}
		}

	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id - 1);

	}

}

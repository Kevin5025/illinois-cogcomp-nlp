package edu.illinois.cs.cogcomp.wikifier.utils.spelling;

import java.io.IOException;
import java.util.List;

import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellCorrection;
import org.xeustechnologies.googleapi.spelling.SpellResponse;

import com.google.common.collect.Lists;

/**
 * 
 * DO NOT USE. THIS SERVICE HAS BEEN DISCONTINUED
 *
 */
public class GoogleSpellChecker extends AbstractSurfaceQueryEngine{

	
	private SpellChecker sc;

	public GoogleSpellChecker() {
		sc = new SpellChecker();
	}
	@Override
	public String[] query(String q) throws IOException {
		SpellResponse response = sc.check(q);
		List<String> ans = Lists.newArrayList();
		for(SpellCorrection tmp: response.getCorrections())
		{
			ans.add(tmp.getValue());
		}
		return ans.toArray(new String[ans.size()]);
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}

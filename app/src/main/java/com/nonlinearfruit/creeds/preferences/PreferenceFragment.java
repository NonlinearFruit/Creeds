package com.nonlinearfruit.creeds.preferences;

import android.os.Bundle;

import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.nonlinearfruit.creeds.R;
import com.nonlinearfruit.creeds.main.MainDatabase;
import com.nonlinearfruit.creeds.main.models.MainMenuItem;

import java.util.List;
import java.util.Set;

public class PreferenceFragment extends PreferenceFragmentCompat {

    private int numberOfCreeds = 0;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preference_screen);
        MultiSelectListPreference preferredCreeds = getPreferredCreeds();
        setPreferredCreedsEntries(preferredCreeds);
        setPreferredCreedsListener(preferredCreeds);
        updatePreferredCreedsSummary(preferredCreeds);
    }

    private MultiSelectListPreference getPreferredCreeds() {
        return (MultiSelectListPreference) findPreference("creeds");
    }

    private void setPreferredCreedsEntries(MultiSelectListPreference preferedCreeds) {
        List<MainMenuItem> items = new MainDatabase().getMainMenuItems();
        CharSequence[] entries = new CharSequence[items.size()];
        for(int i = 0; i < items.size(); i++) {
            MainMenuItem item = items.get(i);
            entries[i] = item.getCreedTitle();
        }
        preferedCreeds.setEntries(entries);
        preferedCreeds.setEntryValues(entries);
        numberOfCreeds = entries.length;
    }

    private void setPreferredCreedsListener(MultiSelectListPreference preferedCreeds) {
        preferedCreeds.setOnPreferenceChangeListener(
                new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        if (preference instanceof MultiSelectListPreference)
                            updatePreferredCreedsSummary((MultiSelectListPreference) preference, (Set<String>) newValue);
                        return true;
                    }
                }
        );
    }

    private void updatePreferredCreedsSummary(MultiSelectListPreference preferedCreeds) {
        updatePreferredCreedsSummary(preferedCreeds, preferedCreeds.getValues());
    }

    private void updatePreferredCreedsSummary(MultiSelectListPreference preferedCreeds, Set<String> values) {
        preferedCreeds.setSummary(values.size()+" / "+numberOfCreeds);
    }
}
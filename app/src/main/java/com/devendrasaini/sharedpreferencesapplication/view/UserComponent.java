package com.devendrasaini.sharedpreferencesapplication.view;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = PhotoApiClient.class)
public interface UserComponent {

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder firstName(@Named("firstName") String firstName);

        @BindsInstance
        Builder lastName(@Named("lastName")String lastName);

        UserComponent build();
    }
}

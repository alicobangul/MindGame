package com.mobilesoftware.zekaoyunu.presentation.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobilesoftware.zekaoyunu.R;
import com.mobilesoftware.zekaoyunu.databinding.FragmentMainBinding;
import com.mobilesoftware.zekaoyunu.util.UserUtil;
import com.mobilesoftware.zekaoyunu.util.DialogUtil;
import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.disposables.CompositeDisposable;

@AndroidEntryPoint
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private MainViewModel mainViewModel;

    private NavController navController;

    private CompositeDisposable compositeDisposable;

    @Inject DialogUtil dialogUtil;

    @Inject UserUtil userUtil;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialize();

        observers();

        performSetup();

    }

    @Override
    public void onDestroyView() {
        dialogUtil.onDestroy();
        compositeDisposable.clear();
        binding = null;
        super.onDestroyView();
    }

    public void initialize() {

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        navController = Navigation.findNavController(binding.getRoot());

        compositeDisposable = new CompositeDisposable();

        binding.setMainViewModel(mainViewModel);

        binding.setLifecycleOwner(this);

    }

    public void performSetup() { mainViewModel.init(); }

    public void observers() {

        mainViewModel.getState().observe(getViewLifecycleOwner(), state -> {

            switch (state.getCurrentDialog()) {

                case LEVELGAMEDIALOG -> dialogUtil.showLevelGameDialog();
                case CHANGESCREENFORCUSTOM -> navController.navigate(R.id.action_mainFragment_to_customFragment);
                case SHOPDIALOG -> dialogUtil.showShopDialog();
                case MOREAPPDIALOG -> dialogUtil.showMoreAppDialog();
                case COMMENTDIALOG -> dialogUtil.showCommentDialog();
                case COINERRORHANDLING -> dialogUtil.showCoinWarning();
            }

        });

        compositeDisposable.addAll(

                dialogUtil.getBehaviorShop().subscribe(isSuccess -> { if (isSuccess) mainViewModel.getUserData(); }),

                dialogUtil.getBehaviorStartGame().subscribe(isSuccess -> { if (isSuccess) {
                    NavDirections action = MainFragmentDirections.actionMainFragmentToGameFragment(mainViewModel.getLevelGameModel());
                    navController.navigate(action);
                } }),

                dialogUtil.getBehaviorMoreApp().subscribe(isSuccess -> { if (isSuccess) userUtil.visitPlayStore(true); }),

                dialogUtil.getBehaviorComment().subscribe(isSuccess -> { if (isSuccess) userUtil.inAppReview(); })

        );

    }

}
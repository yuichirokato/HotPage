package jp.ac.jec.cm0101.hotpage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import jp.ac.jec.cm0101.hotpage.fragments.ActFragment;
import jp.ac.jec.cm0101.hotpage.fragments.CurriculumFragment;
import jp.ac.jec.cm0101.hotpage.fragments.EventFragment;
import jp.ac.jec.cm0101.hotpage.fragments.JobHuntingFragment;
import jp.ac.jec.cm0101.hotpage.fragments.PeopleFragment;

public class HPFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    public HPFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // positionに応じて表示するフラグメントを変える(･∀･) ｶｴﾙ!!
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CurriculumFragment.getInstance();
            case 1:
                return ActFragment.getInstance();
            case 2:
                return EventFragment.getInstance();
            case 3:
                return PeopleFragment.getInstance();
            case 4:
                return JobHuntingFragment.getInstance();
            default:
                return CurriculumFragment.getInstance();
        }
    }

    // ページ数(フラグメントの総数)を返す
    @Override
    public int getCount() {
        return 5;
    }

    // 表示しているフラグメント毎にタイトルを変える(･∀･) ｶｴﾙ!!
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Curriculum";
            case 1:
                return "Act";
            case 2:
                return "Event";
            case 3:
                return "People";
            case 4:
                return "JobHunting";
            default:
                return "Curriculum";
        }
    }
}

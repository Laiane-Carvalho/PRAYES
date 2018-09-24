package testeadapt3.cursoandroid2.com.pray.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by laianeoliveira on 18/09/18.
 */
public class Filho implements Parcelable {

    private String descricao;
    private int nameID;

    private Filho(Parcel p) {
        descricao = p.readString();
        nameID = p.readInt();
    }

    public static final Parcelable.Creator <Filho>
            CREATOR = new Parcelable.Creator <Filho>() {


        public Filho createFromParcel(Parcel in) {
            return new Filho( in );
        }

        public Filho[] newArray(int size) {
            return new Filho[size];
        }
    };

    public Filho(String descricao, int nameID) {
        this.descricao = descricao;
        this.nameID = nameID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNameID() {
        return nameID;
    }

    public void setNameID(int nameID) {
        this.nameID = nameID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( descricao );
        dest.writeInt( nameID );
    }
}


package edu.psuti.alexandrov.stellar;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.NDManager;
import ai.djl.training.dataset.RandomAccessDataset;
import ai.djl.training.dataset.Record;
import ai.djl.util.Progress;

import java.util.List;

public class StellarDataset extends RandomAccessDataset {

    private final List<StellarObject> csvObjects;

    public StellarDataset(Builder builder) {
        super(builder);
        this.csvObjects = builder.csvObjects;
    }

    @Override
    public Record get(NDManager manager, long index) {
        var stellarObject = csvObjects.get(Math.toIntExact(index));
        var label = manager.create(stellarObject.getOutputClass().toString());
        var datum = stellarObject
                .datumStream()
                .map(manager::create)
                .toArray(NDArray[]::new);
        return new Record(new NDList(datum), new NDList(label));
    }

    @Override
    protected long availableSize() {
        return csvObjects.size();
    }

    @Override
    public void prepare(Progress progress) { }

    public static final class Builder extends BaseBuilder<Builder> {

        private final List<StellarObject> csvObjects;

        public Builder(List<StellarObject> csvObjects) {
            this.csvObjects = csvObjects;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public StellarDataset build() {
            return new StellarDataset(this);
        }
    }
}
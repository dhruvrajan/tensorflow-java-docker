/*
 *  Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  =======================================================================
 */

package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.internal.buffer.TensorBuffers;
import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.tools.Shape;
import org.tensorflow.tools.buffer.IntDataBuffer;
import org.tensorflow.tools.ndarray.IntNdArray;
import org.tensorflow.tools.ndarray.NdArray;
import org.tensorflow.tools.ndarray.impl.dense.IntDenseNdArray;
import org.tensorflow.types.family.TNumber;

public interface TInt32 extends IntNdArray, TNumber {

  DataType<TInt32> DTYPE = DataType.create("INT32", 3, 4, TInt32Impl::mapTensor);

  static Tensor<TInt32> scalarOf(int value) {
    Tensor<TInt32> t = ofShape();
    t.data().setInt(value);
    return t;
  }

  static Tensor<TInt32> vectorOf(int... values) {
    Tensor<TInt32> t = ofShape(values.length);
    t.data().write(values);
    return t;
  }

  static Tensor<TInt32> ofShape(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }

  static Tensor<TInt32> ofShape(long... dimensionSizes) {
    return Tensor.allocate(DTYPE, Shape.make(dimensionSizes));
  }

  static Tensor<TInt32> copyOf(NdArray<Integer> src) {
    Tensor<TInt32> t = Tensor.allocate(DTYPE, src.shape());
    src.copyTo(t.data());
    return t;
  }
}

class TInt32Impl extends IntDenseNdArray implements TInt32 {

  static TInt32 mapTensor(TF_Tensor nativeTensor, Shape shape) {
    return new TInt32Impl(TensorBuffers.toInts(nativeTensor), shape);
  }

  private TInt32Impl(IntDataBuffer buffer, Shape shape) {
    super(buffer, shape);
  }
}

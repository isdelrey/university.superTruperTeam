/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author bassagap
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({editor.AudioBufferTest.class, editor.VectorTest.class, editor.ObjectCollectionTest.class, editor.MatrixTest.class, editor.FrameTest.class, editor.ColorFrameTest.class, editor.BWFrameTest.class, editor.BufferTest.class, editor.EditorTest.class})
public class EditorSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

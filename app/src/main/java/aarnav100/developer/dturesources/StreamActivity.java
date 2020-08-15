package aarnav100.developer.dturesources;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import aarnav100.developer.dturesources.Adapters.ListAdapter;
import aarnav100.developer.dturesources.Models.ListSubject;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;

public class StreamActivity extends AppCompatActivity {

    private String type;
    private String stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        ImageView backbutton=findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        type = getIntent().getStringExtra("type");
        stream = getIntent().getStringExtra("stream");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(false);
        VerticalRecyclerViewFastScroller fastScroller = (VerticalRecyclerViewFastScroller)findViewById(R.id.fast_scroller);
        fastScroller.setRecyclerView(recyclerView);
        recyclerView.setOnScrollListener(fastScroller.getOnScrollListener());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<ListSubject> ListSubjectList = new ArrayList<>();
        switch(stream){
            case "COE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Analog Electronics", R.drawable.coe));
                ListSubjectList.add(new ListSubject("Data Structure",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Object Oriented Programming",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Discrete Structures",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Digital Electronics",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("DBMS",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Operating System Design",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Comp Org & Arch",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Algo Design and Analysis",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Software Engineering",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Theory of Computation",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Compiler Design",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Artificial Intelligence",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Computer Networks",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Information and Network Security",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Distributed System",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Information and Network Security",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("Distributed Systems",  R.drawable.coe));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Data-Warehousing and Data Mining",  R.drawable.coe));
                break;

            case "CE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Basic Electronics & Instrumentation", R.drawable.civil));
                ListSubjectList.add(new ListSubject("Civil Engineering Basics and Applications",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Engineering Mechanics",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Fluid Mechanics",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Environmental Engineering",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Mechanics of solids",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Engineering Survey",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Soil Mechanics",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Hydraulics & Hydraulic Machines",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Analysis of Determinate Structures",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Design of RCC structures",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Analysis of Indeterminate Structures",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Geotechnical Engineering",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Transportation Engineering",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Design of Steel Structures",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("Water Resources Engineering",  R.drawable.civil));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Construction Technology & Management",  R.drawable.civil));
                break;

            case "BT":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Applied Mathematics", R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Introduction to Biotechnology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Biochemistry",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Biochemical Engineering Principles",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design BT",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Data Structure and Algorithm",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Molecular Biology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Genetics",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Microbiology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Structural Biology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Immunology and Immuno-Technology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Genetic Engineering",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Plant Biotechnology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Animal Biotechnology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Genomics and Proteomics",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Fundamental of Computational Biology",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("Bioprocess Tech & Downstream Process",  R.drawable.biotech));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Advances in Computational Biology",  R.drawable.biotech));
                break;

            case "ECE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Electronic Instrumentation and Measurements", R.drawable.ece));
                ListSubjectList.add(new ListSubject("Analog Electronics – I",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Digital Design – I",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Signals & Systems",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Engineering Analysis & Design",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Electromagnetics",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Analog Electronics–II",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Digital Design – II",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Communication Systems",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Computer Architecture",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Digital Communication",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Linear Integrated Circuits",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("VLSI Design",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Digital Signal Processing",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Embedded Systems",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Microwave Engineering",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("Optical Communication",  R.drawable.ece));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Wireless Communication",  R.drawable.ece));
                break;

            case "EE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Numerical and Engineering Optimization Methods", R.drawable.ee));
                ListSubjectList.add(new ListSubject("Network Analysis & Synthesis",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Electronic Devices and Circuits",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Electromechanical Energy Conversion and Transformer",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Power Plant Engineering",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Electromagnetic Field Theory",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Digital circuits and System",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Control Systems",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Asynchronous and Synchronous Machines",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Power Electronics",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Power Transmission and Distribution",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Electric Drives",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Power System Analysis",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Microprocessors & Microcontroller Applications",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Digital Signal Processing",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Instrumentation and Measurement",  R.drawable.ee));
                ListSubjectList.add(new ListSubject("Switchgear and Protection",  R.drawable.ee));
                break;

            case "ENE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Building Material & Construction", R.drawable.envi));
                ListSubjectList.add(new ListSubject("Strength of Materials",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Engineering & Environmental Surveying",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Environmental Chemistry & Microbiology",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Engineering Analysis & Design",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Structural Analysis",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Geotechnical Engineering",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Water Engineering: Design & Application",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Engineering Geology, GIS & Remote Sensing",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Fluid Mechanics & Hydraulic Machines",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Waste Water Engineering",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Instrumentation Techniques",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Solid Waste Management",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Air Pollution & Control",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Hydrology & Ground Water Engineering",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Vibration Analysis & Control of Noise Pollution",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Industrial Waste Management",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.envi));
                ListSubjectList.add(new ListSubject("Environmental Impact Assessment & Audit",  R.drawable.envi));
                break;

            case "EP":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Engineering Mechanics", R.drawable.ep));
                ListSubjectList.add(new ListSubject("Introduction to Computing",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Mathematical Physics",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Classical and Quantum Mechanics",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Digital Electronics",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Communication System",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Condensed Matter Physics",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Optics",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Microprocessor and Interfacing",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Computational Methods",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Semiconductor Devices",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Electromagnetic Theory, antennas and Propagation",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Fiber Optics and Optical Communication",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Fabrication and Characterization of Nanostructures",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Microwave Engineering",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("VLSI and FPGA design",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Mobile and Satellite communication",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.ep));
                ListSubjectList.add(new ListSubject("Alternate Energy Storage and Conversion Devices",  R.drawable.ep));
                break;

            case "IT":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Analog Electronics", R.drawable.it));
                ListSubjectList.add(new ListSubject("Data Structure",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Object Oriented Programming",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Discrete Structures",  R.drawable.it));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Digital Electronics",  R.drawable.it));
                ListSubjectList.add(new ListSubject("DBMS",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Operating System Design",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Comp Org & Arch",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Algo Design ana Analysis",  R.drawable.it));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Theory of Computation",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Computer Networks",  R.drawable.it));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Compiler Design",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Software Engineering",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Artificial Intelligence and Expert Systems",  R.drawable.it));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Data-warehouse and Data mining",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Information and Network Security",  R.drawable.it));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.it));
                ListSubjectList.add(new ListSubject("Big Data Analytics",  R.drawable.it));
                break;

            case "MAM":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Quantitative Techniques", R.drawable.mam));
                ListSubjectList.add(new ListSubject("Engineering Mechanics",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Thermodynamics",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Manufacturing Machines",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Automotive Electrical and Electronics",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Heat and Mass Transfer",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Theory of Machines",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Mechanics of Solids",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Material Engineering & Metallurgy",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Manufacturing Technology",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Fluid Mechanics And Hydraulic Machines",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Design of Machine Elements",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Internal Combustion Engines",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Design of Automobile Components",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Alternative Fuels And Energy Systems",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Production And Operations Management",  R.drawable.mam));
                ListSubjectList.add(new ListSubject("Computer Aided Vehicle Design And Safety",  R.drawable.mam));
                break;

            case "MC":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Mathematics-III", R.drawable.mc));
                ListSubjectList.add(new ListSubject("Data Structure",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Probability & Statistics",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Discrete Mathematics",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Real Analysis",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Scientific Computing",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Linear Algebra",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Comp Org & Arch",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Algo Design ana Analysis",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Operating System",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Stochastic Processes",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("DBMS",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Theory of Computation",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Financial Engineeringy",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Graph Theory",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Cryptography & Network Security",  R.drawable.mc));
                ListSubjectList.add(new ListSubject("Mathematical Modeling & Simulation",  R.drawable.mc));
                break;

            case "ME":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Engineering Materials & Metallurgy", R.drawable.me));
                ListSubjectList.add(new ListSubject("Mechanics of Solids",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Thermal Engineering-I",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Machine Drawing and Solid Modeling",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.me));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Manufacturing Machines",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Thermal Engineering-II",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Fluid Mechanics",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Kinematics of Machines",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Manufacturing Technology-I",  R.drawable.me));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Fluid Systems",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Dynamics of Machines",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Design of Machine Elements",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Manufacturing Technology-II",  R.drawable.me));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Heat And Mass Transfer",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Production and Operations Management",  R.drawable.me));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Refrigeration & Air Conditioning",  R.drawable.me));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.me));
                ListSubjectList.add(new ListSubject("Industrial Engineering",  R.drawable.me));
                break;

            case "PCT":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Basic Electronics Engg", R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Principles of Polymerization",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Elements of Chemical Engg",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Chemical Engineering Thermodynamics",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design PCT",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Instrumentation and Control",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Fluid Mechanics",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Polymer Processing",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Polymer Structure and Properties",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Chemical Reaction Engg",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Heat Transfer",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Polymer Processing Techniques",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Technical Communication",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Rubber Technology",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Mass Transfer",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Plastic Technology",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Fibre Technology",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Chemical Process Technology",  R.drawable.white));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.polymer));
                ListSubjectList.add(new ListSubject("Polymer Product and Die Design",  R.drawable.polymer));
                break;

            case "PIE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Kinematic And Dynamic Of Machines", R.drawable.pie));
                ListSubjectList.add(new ListSubject("Engineering Materials & Metallurgy",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Thermal Engineering-I",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Manufacturing Machines",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Engineering Analysis And Design",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Machine Design",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Thermal Engineering-II",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Industrial Engineering & Operation Research",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Fluid Mechanics & Machinery",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Metal Cutting &Tool Design",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Casting Technology",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Casting Technology",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Welding Technology",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Precision Manufacturing",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Metrology & Quality Assurance",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Metal Forming & Press Working",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Quantitative Techniques",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.pie));
                ListSubjectList.add(new ListSubject("Total Quality Management",  R.drawable.pie));
                break;

            case "SE":
                ListSubjectList.add(new ListSubject("SEM 3",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Analog Electronics", R.drawable.software));
                ListSubjectList.add(new ListSubject("Data Structure",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Object Oriented Programming",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Web Technology",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Engineering Analysis and Design",  R.drawable.software));
                ListSubjectList.add(new ListSubject("SEM 4",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Digital Electronics",  R.drawable.software));
                ListSubjectList.add(new ListSubject("DBMS",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Software Engineering",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Comp Org & Arch",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Algo Design ana Analysis",  R.drawable.software));
                ListSubjectList.add(new ListSubject("SEM 5",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Object Oriented Software Engineering",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Algorithm Design & Analysis",  R.drawable.software));
                ListSubjectList.add(new ListSubject("SEM 6",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Compiler Design",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Software Testing",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Operating System",  R.drawable.software));
                ListSubjectList.add(new ListSubject("SEM 7",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Software Project Management",  R.drawable.software));
                ListSubjectList.add(new ListSubject("Computer Networks",  R.drawable.software));
                ListSubjectList.add(new ListSubject("SEM 8",  R.drawable.white));
                ListSubjectList.add(new ListSubject("Empirical Software Engineering",  R.drawable.software));
                break;

            case "PC":
                ListSubjectList.add(new ListSubject("Coding", R.drawable.placement));
                ListSubjectList.add(new ListSubject("Aptitude",  R.drawable.placement));
                ListSubjectList.add(new ListSubject("Non Tech",  R.drawable.placement));

        }

        RecyclerView.Adapter mAdapter=new ListAdapter(this,ListSubjectList,type);
        recyclerView.setAdapter(mAdapter);
    }
}
